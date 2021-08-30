package carrefour.drivers;

public final class DriverFactory {

    public static Driver getDriver(String location, String platform, String device) {
        if (location.equalsIgnoreCase("LOCAL")) {
            return new LocalDriver(location, platform, device);
        }
        throw new RuntimeException("Type of driver unknown [" + location + "]");
    }
}
