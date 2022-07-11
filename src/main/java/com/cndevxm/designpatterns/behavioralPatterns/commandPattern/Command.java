package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class Command {

    public abstract void execute();

}
