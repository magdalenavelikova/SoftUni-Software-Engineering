package designPattern.commandPattern;

public class VolumeUp implements Command {
    private RemoteControl remoteControl;

    public VolumeUp(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    @Override
    public void execute() {
        remoteControl.setVolume(remoteControl.getVolume() + 1);
    }
}
