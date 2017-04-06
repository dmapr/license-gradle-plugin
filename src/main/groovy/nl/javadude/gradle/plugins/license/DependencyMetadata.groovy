package nl.javadude.gradle.plugins.license

import groovy.transform.Canonical

/**
 * Dependency metadata. Contains:
 * Dependency name, license metadata list.
 */
@Canonical
class DependencyMetadata implements Serializable {

    /**
     * Create Dependency metadata for dependencies without licenses.
     */
    public static final DependencyMetadata noLicenseMetaData(String dependencyName,
                                                             String dependencyVersion = null,
                                                             String dependencyFriendlyName = null,
                                                             String dependencyDescription = null,
                                                             String dependencyUrl = null,
                                                             String fileName = null) {
        return new DependencyMetadata(dependency: dependencyName, fileName: fileName,
                version: dependencyVersion, friendlyName: dependencyFriendlyName,
                licenseMetadataList: [new LicenseMetadata(licenseName: "No license found")],
                description: dependencyDescription, url: dependencyUrl, licenseFound: false
        )
    }

    /**
     * List with license metadata.
     */
    List<LicenseMetadata> licenseMetadataList = []

    /**
     * Dependency name.
     */
    String dependency

    /**
     * Dependency url.
     */
    String url

    /**
     * Dependency jar file name.
     */
    String fileName

    /**
     * User-friendly dependency name
     */
    String friendlyName

    /**
     * Description of the library
     */
    String description

    /**
     * Dependency version
     */
    String version

    /**
     * Whether the license was found or not
     */
    Boolean licenseFound

    /**
     * Check whether metadata list is empty.
     *
     * @return license metadata list is empty or not
     */
    boolean hasLicense() {
       !licenseMetadataList.empty
    }

    /**
     * Add license.
     *
     * @param licenseMetadata license metadata to add
     */
    void addLicense(LicenseMetadata licenseMetadata) {
        licenseMetadataList.add(licenseMetadata)
    }

}
