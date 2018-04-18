package com.amazonaws.lambda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInfo {
	 private String username;
	 private String email;
     private String password;
}