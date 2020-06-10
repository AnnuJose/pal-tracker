package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class CustomInfoContributor  implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> custom = new HashMap<>();
        custom.put("testing Info", 1);
        builder.withDetail("custom", custom);
    }
}
