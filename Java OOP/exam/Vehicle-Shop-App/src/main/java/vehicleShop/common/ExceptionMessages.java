package vehicleShop.common;

public class ExceptionMessages {
    public static final String WORKER_NAME_NULL_OR_EMPTY = "Worker name cannot be null or empty.";

    public static final String WORKER_STRENGTH_LESS_THAN_ZERO = "Cannot create a Worker with negative strength.";

    public static final String VEHICLE_NAME_NULL_OR_EMPTY = "Vehicle name cannot be null or empty.";

    public static final String VEHICLE_STRENGTH_LESS_THAN_ZERO = "Cannot create a Vehicle requiring negative strength.";

    public static final String TOOL_POWER_LESS_THAN_ZERO = "Cannot create a Tool with negative power.";

    public static final String WORKER_TYPE_DOESNT_EXIST = "Worker type doesn't exist.";

    public static final String NO_WORKER_READY = "There is no worker ready to start making.";

    public static final String HELPER_DOESNT_EXIST = "The worker doesn't exist. You cannot add a tool.";

}
