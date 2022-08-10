package com.example.mslogin.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 * Custom error.
 */
@Data
public class CustomError {
  private Timestamp timestamp;
  private int codigo;
  private String detail;
}
