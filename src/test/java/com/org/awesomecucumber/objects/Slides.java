package com.org.awesomecucumber.objects;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class Slides {
    private String title;
    private String href;
    private int duration;

}
