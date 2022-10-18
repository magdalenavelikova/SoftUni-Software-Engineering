package ObjectsAndClassesLab;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Songs {
    static class Song {
        String typeList;
        String name;
        String time;

        Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getTime() {
            return time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Song> songsList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] songsArr = (scanner.nextLine().split("_"));
            Song currentSong = new Song(songsArr[0], songsArr[1], songsArr[2]);

            songsList.add(currentSong);

        }
        String command = scanner.nextLine();
        if (command.equals("all")) {
            for (Song item : songsList) {
                System.out.println(item.getName());
            }
        }else {
            for (Song item : songsList) {
                if(item.getTypeList().equals(command)) {
                    System.out.println(item.getName());
                }
            }

        }
    //    System.out.println();

    }
}
