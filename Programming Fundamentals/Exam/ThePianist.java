package exam;


import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, String> mapByPieces = new LinkedHashMap<>();
        for (int i = 0; i < numberOfPieces; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];
            String composerKey = composer + ", " + key;
            mapByPieces.putIfAbsent(piece, composerKey);


        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String piece = command.split("\\|")[1];
            String currentCommand = command.split("\\|")[0];
            if (currentCommand.equals("Add")) {
                String composer = command.split("\\|")[2];
                String key = command.split("\\|")[3];
                String composerKey = composer + ", " + key;
                if (mapByPieces.containsKey(piece)) {
                    System.out.printf("%s is already in the collection!%n", piece);
                } else {
                    mapByPieces.putIfAbsent(piece, composerKey);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                }
            } else if (currentCommand.equals("Remove")) {
                if (!mapByPieces.containsKey(piece)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                } else {
                    mapByPieces.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                }

            } else if (currentCommand.equals("ChangeKey")) {
                String newKey = command.split("\\|")[2];
                if (!mapByPieces.containsKey(piece)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                } else {
                    String current = mapByPieces.get(piece);
                    String oldKey = current.split(", ")[1];
                    String newKeyForAdd=current.replace(oldKey, newKey);
                    mapByPieces.put(piece, newKeyForAdd );
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                }

            }


            command = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : mapByPieces.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().split(", ")[0], entry.getValue().split(", ")[1]);

        }

    }
}
