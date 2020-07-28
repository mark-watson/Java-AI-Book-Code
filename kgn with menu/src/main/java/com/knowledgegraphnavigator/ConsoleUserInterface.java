package com.knowledgegraphnavigator;

// uses https://github.com/awegmann/consoleui by Andreas Wegmann (Apache 2 license) - see pom.xml

import static com.knowledgegraphnavigator.Log.out;

import de.codeshelf.consoleui.elements.PromptableElementIF;
import de.codeshelf.consoleui.elements.items.CheckboxItemIF;
import de.codeshelf.consoleui.prompt.CheckboxResult;
import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.PromtResultItemIF;
import de.codeshelf.consoleui.prompt.builder.CheckboxPromptBuilder;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import jline.TerminalFactory;

import java.util.*;

public class ConsoleUserInterface {
  public ConsoleUserInterface() {
  }


  public String getUserQueryFromConsole() {
    out("Enter entities query:");
    Scanner input = new Scanner(System.in);
    String ret = "";
    while (input.hasNext()) {
      ret = input.nextLine();
      break;
    }
    return ret;
  }

  public List<EntityAndDescription> selectUsingCheckBox(List<EntityAndDescription> items) throws Exception {
    List<EntityAndDescription> ret = new ArrayList<>();
    ConsolePrompt prompt = new ConsolePrompt();
    PromptBuilder promptBuilder = prompt.getPromptBuilder();
    List<CheckboxItemIF> list = new ArrayList<CheckboxItemIF>();
    CheckboxPromptBuilder pp = promptBuilder.createCheckboxPrompt()
        .name("entities")
        //.message("Please select 1 or more:")
        .newSeparator("entities")
        .add();
    int count = 0;
    for (EntityAndDescription ead : items) {
      int len = Math.min(70, ead.entityUri.length());
      pp.newItem().name("" + count + " " + ead.entityName).text(ead.entityName + " || " + ead.entityUri.substring(0, len)).add();
      count += 1;
    }
    pp.addPrompt();
    List<PromptableElementIF> promptableElementList = promptBuilder.build();
    HashMap<String, ? extends PromtResultItemIF> ret2 = prompt.prompt(promptableElementList);
    CheckboxResult o1 = (CheckboxResult)ret2.get("entities");
    for (String s : o1.getSelectedIds()) {
      int index = s.indexOf(' ');
      if (index > -1) {
        int i = Integer.parseInt(s.substring(0, index));
        ret.add(items.get(i));
      }
    }
    TerminalFactory.get().restore();
    for (Thread aThread : Thread.getAllStackTraces().keySet()) {
      if (aThread.getName().startsWith("NonBlockingInputStreamThread")) {
        aThread.stop();
      }
    }
    return ret;
  }

  public static void main(String[] args) throws Exception {
    ConsoleUserInterface console = new ConsoleUserInterface();
    String query = console.getUserQueryFromConsole();
    System.out.println("++ query: " + query);
  }
}
