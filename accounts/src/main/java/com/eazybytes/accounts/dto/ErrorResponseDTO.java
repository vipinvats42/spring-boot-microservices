package com.eazybytes.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "ErrorResponse",
description = "Schema to hold error response information")

public class ErrorResponseDTO {
    @Schema(description = "api path invoked by client")
    private String apiPath;

    @Schema(description = "Error code reperesenting the error happen")
    private HttpStatus errorCode;

    @Schema(description = "Error message reperesenting the error happen")
    private String errorMessage;

    @Schema(description = "Time reperesenting when the error happen")
    private LocalDateTime errorTime;
}
