package plymorphismExercise.word;

import java.util.*;

public class CommandImpl implements CommandInterface {

    class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    private class CutTransform implements TextTransform {
        private String lastCut;

        public String getLastCut() {
            return lastCut;
        }

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            lastCut = text.substring(startIndex, endIndex);
             text.replace(startIndex, endIndex, "");

        }
    }

    private class PasteTransform  implements TextTransform {
        private CutTransform lastCut;

        public PasteTransform(CutTransform lastCut) {
            this.lastCut = lastCut;
        }

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            text.replace(startIndex, endIndex, lastCut.getLastCut());
        }
    }

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        CutTransform cutTransform = new CutTransform();
        commands.add(new Command("cut", cutTransform));
        commands.add(new Command("paste", new PasteTransform(cutTransform)));

        return commands;
    }


}
