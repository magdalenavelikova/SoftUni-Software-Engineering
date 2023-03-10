package designPattern.commandPattern;

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl=new RemoteControl();
        VolumeUp volumeUp=new VolumeUp(remoteControl);
        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();

    }
}
