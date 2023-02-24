package interfacesAndAbstractionExercise.militaryElite;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<PrivateImpl> privatesImpl;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        privatesImpl = new ArrayList<>();
    }

    public void addPrivate(Private priv) {
        PrivateImpl privateImpl = new PrivateImpl(priv.getId(), priv.getFirstName(), priv.getLastName(), priv.getSalary());
        privatesImpl.add(privateImpl);
    }

    @Override
    public List<PrivateImpl> getPrivatesImpl() {
        return privatesImpl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator()).append("Privates:");
        if (privatesImpl.size() > 0) {
            sb.append(System.lineSeparator());
            privatesImpl.stream().sorted(Comparator.comparing(PrivateImpl::getFirstName).reversed())
                    .forEach(s -> sb.append(" ").append(s).append(System.lineSeparator()));
        }
        return sb.toString();
    }
}

