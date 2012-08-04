package geneticalgorithm;

import java.util.*;

/**
 * Genetic Algorithm Java classes
 *
 * <p/>
 * Copyright 1996-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
abstract public class Genetic {

	protected int numGenesPerChromosome; // number of genes per chromosome
	protected int numChromosomes; // number of chromosomes
	List<Chromosome> chromosomes;
	private float crossoverFraction;
	private float mutationFraction;
	private int[] rouletteWheel;
	private int rouletteWheelSize;

	public Genetic(int num_genes_per_chromosome, int num_chromosomes) {
		this(num_genes_per_chromosome, num_chromosomes, 0.8f, 0.01f);
	}

	public Genetic(int num_genes_per_chromosome, int num_chromosomes,
			float crossover_fraction, float mutation_fraction) {
		numGenesPerChromosome = num_genes_per_chromosome;
		numChromosomes = num_chromosomes;
		crossoverFraction = crossover_fraction;
		mutationFraction = mutation_fraction;
		chromosomes = new ArrayList<Chromosome>(num_chromosomes);
		for (int i = 0; i < num_chromosomes; i++) {
			chromosomes.add(new Chromosome(numGenesPerChromosome));
			for (int j = 0; j < num_genes_per_chromosome; j++) {
				chromosomes.get(i).setBit(j, Math.random() < 0.5);
			}
		}
		sort();
		// define the roulette wheel:
		rouletteWheelSize = 0;
		for (int i = 0; i < numGenesPerChromosome; i++) {
			rouletteWheelSize += i + 1;
		}
		System.out.println("count of slots in roulette wheel="
				+ rouletteWheelSize);
		rouletteWheel = new int[rouletteWheelSize];
		int num_trials = numGenesPerChromosome;
		int index = 0;
        //for (int i = 0; i < numGenesPerChromosome; i++) { // !ERROR
        for (int i = 0; i < numChromosomes; i++) { // bug fixed 3/31/2009
			for (int j = 0; j < num_trials; j++) {
				rouletteWheel[index++] = i;
			}
			num_trials--;
		}
	}
	
	public void sort() {
		Collections.sort(chromosomes, new ChromosomeComparator());
	}

	public boolean getGene(int chromosome, int gene) {
		return chromosomes.get(chromosome).getBit(gene);
	}

	public void setGene(int chromosome, int gene, int value) {
		chromosomes.get(chromosome).setBit(gene, value != 0);
	}

	public void setGene(int chromosome, int gene, boolean value) {
		chromosomes.get(chromosome).setBit(gene, value);
	}

	public void evolve() {
		calcFitness();
		sort();
		doCrossovers();
		doMutations();
		doRemoveDuplicates();
	}

	public void doCrossovers() {
		int num = (int) (numChromosomes * crossoverFraction);
		for (int i = num - 1; i >= 0; i--) {
			// 8/11/2008: don't overwrite the "best" chromosome from current generation:
			int c1 = 1 + (int) ((rouletteWheelSize - 1) * Math.random() * 0.9999f);
			int c2 = 1 + (int) ((rouletteWheelSize - 1) * Math.random() * 0.9999f);
			c1 = rouletteWheel[c1];
			c2 = rouletteWheel[c2];
			if (c1 != c2) {
				int locus = 1 + (int) ((numGenesPerChromosome - 2) * Math
						.random());
				for (int g = 0; g < numGenesPerChromosome; g++) {
					if (g < locus) {
						setGene(i, g, getGene(c1, g));
					} else {
						setGene(i, g, getGene(c2, g));
					}
				}
			}
		}
	}

	public void doMutations() {
		int num = (int) (numChromosomes * mutationFraction);
		for (int i = 0; i < num; i++) {
			// 8/11/2008: don't overwrite the "best" chromosome from current generation:
			int c = 1 + (int) ((numChromosomes - 1) * Math.random() * 0.99);
			int g = (int) (numGenesPerChromosome * Math.random() * 0.99);
			setGene(c, g, !getGene(c, g));
		}
	}

	public void doRemoveDuplicates() {
		for (int i = numChromosomes - 1; i > 3; i--) {
			for (int j = 0; j < i; j++) {
				if (chromosomes.get(i).equals(chromosomes.get(j))) {
					int g = (int) (numGenesPerChromosome * Math.random() * 0.99);
					setGene(i, g, !getGene(i, g));
					break;
				}
			}
		}
	}

	// Override the following function in sub-classes:
	abstract public void calcFitness();
}

class Chromosome {
	BitSet chromosome;
	float fitness = -999;

	private Chromosome() { }
	public Chromosome(int num_genes) { chromosome = new BitSet(num_genes); }
	public boolean getBit(int index) {
		return chromosome.get(index);
	}
    public String toString() {
      return "[Chromosome: fitness: " + fitness + ", bit set: " + chromosome+"]";
    }
	public void setBit(int index, boolean value) {
		chromosome.set(index, value);
	}

	public float getFitness() {
		return fitness;
	}

	public void setFitness(float value) {
		fitness = value;
	}

	public boolean equals(Chromosome c) {
		return chromosome.equals(c.chromosome);
	}
}

class ChromosomeComparator implements Comparator<Chromosome> {
	public int compare(Chromosome o1, Chromosome o2) {
		return (int) (1000 * (o2.getFitness() - o1.getFitness()));
	}
}
