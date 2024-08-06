package main.java.calculator;

/**
 * This class holds the version information of the application.
 * The version follows Semantic Versioning (https://semver.org/).
 */
public final class Version {
    /** The major version number. */
    public static final int MAJOR = 2;
    /** The minor version number. */
    public static final int MINOR = 2;
    /** The patch version number. */
    public static final int PATCH = 3;

    /**
     * Private constructor to prevent instantiation.
     */
    private Version() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Returns the version string in the format MAJOR.MINOR.PATCH.
     *
     * @return the version string.
     */
    public static String getVersion() {
        return MAJOR + "." + MINOR + "." + PATCH;
    }
}
