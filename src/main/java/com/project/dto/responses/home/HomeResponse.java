package com.project.dto.responses.home;

import com.project.dto.responses.Response;

public class HomeResponse extends Response {
    public HomeResponse(Boolean success, String message) {
        super(success, message);
    }
}
