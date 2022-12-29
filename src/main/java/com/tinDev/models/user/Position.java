package com.tinDev.models.user;

import lombok.Data;
import com.tinDev.models.user.enums.Carrier;
import com.tinDev.models.user.enums.Seniority;


public class Position {
    private Carrier carrier;
    private Seniority seniority;
}
