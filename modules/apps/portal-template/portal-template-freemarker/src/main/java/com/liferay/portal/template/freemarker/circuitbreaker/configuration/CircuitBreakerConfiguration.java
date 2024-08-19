package com.liferay.portal.template.freemarker.circuitbreaker.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.template.freemarker.circuitbreaker.constants.CircuitBreakerConfigurationsConstants;

/**
 * @author andersonperrelli
 */

@ExtendedObjectClassDefinition(
        category = CircuitBreakerConfigurationsConstants.CONFIG_CATEGORY_NAME,
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        id = CircuitBreakerConfigurationsConstants.CIRCUITBREAKER_CONFIG_ID,
        localization = "content/Language",
        name = CircuitBreakerConfigurationsConstants.CONFIG_NAME
)
public interface CircuitBreakerConfiguration {

    @Meta.AD(
            name = "minimum-number-of-calls",
            required = false,
            deflt="4",
            description = "minimum-number-of-calls-description"
    )
    public Integer minimumNumberOfCalls();

    @Meta.AD(
            name = "failure-rate-threshold",
            required = false,
            deflt="50",
            description="failure-rate-threshold-description"
    )
    public float failureRateThreshold();

    @Meta.AD(
            name = "slow-call-rate-threshold",
            required = false,
            deflt="50",
            description="slow-call-rate-threshold-description"
    )
    public float slowCallRateThreshold();

    @Meta.AD(
            name = "wait-duration-in-open-state",
            required = false,
            deflt="30",
            description="wait-duration-in-open-state-description"
    )
    public Integer waitDurationInOpenState();

    @Meta.AD(
            name = "slow-call-duration-threshold",
            required = false,
            deflt="600",
            description="slow-call-duration-threshold-description"
    )
    public Integer slowCallDurationThreshold();

    @Meta.AD(
            name = "max-attempts",
            required = false,
            deflt="5",
            description="max-attempts-description"
    )
    public Integer maxAttempts();

    @Meta.AD(
            name = "wait-durations-next-attempts",
            required = false,
            deflt="3000",
            description="wait-durations-next-attempts-description"
    )
    public Integer waitDuration();

}
