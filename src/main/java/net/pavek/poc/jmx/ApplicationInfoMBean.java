package net.pavek.poc.jmx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(objectName="Application:name=ApplicationInfo")
@Component
public class ApplicationInfoMBean implements ApplicationInfo {

    @Value("${project.version}")
    private String version;

    @ManagedOperation(description="Get application name")
    @Override
    public String getApplicationName() {
        return "POC - application version for JMX";
    }

    @ManagedOperation(description="Get application version")
    @Override
    public String getVersion() {
        return this.version;
    }

}
