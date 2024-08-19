package com.liferay.portal.template.freemarker.circuitbreaker.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

/**
 * @author andersonperrelli
 */

@Component(service = ConfigurationCategory.class)
public class CircuitBreakerConfigurationCategory implements ConfigurationCategory{

    @Override
    public String getCategoryKey() {
        return "template-engines";
    }

    @Override
    public String getCategorySection() {
        return "circuitbreaker-section";
    }
}
