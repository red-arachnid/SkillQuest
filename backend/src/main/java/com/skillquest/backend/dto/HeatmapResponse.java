package com.skillquest.backend.dto;

import java.time.LocalDate;

public record HeatmapResponse(LocalDate date, int count) {}
