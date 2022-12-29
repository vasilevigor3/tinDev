package com.tinDev.models.stack;

import com.tinDev.models.stack.skils.AbstractSkill;
import lombok.Data;

import java.util.List;

@Data
public class Back {
    private List<AbstractSkill> skills;
}
