/**
 * 
 */
package com.ieso.personapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ieso.personapi.entity.Phone;
import com.ieso.personapi.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
	
	private Long id;
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;
	
	public static PhoneDTO toDTO(Phone phone) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setId(phone.getId());
		phoneDTO.setNumber(phone.getNumber());
		phoneDTO.setType(phone.getType());
		return phoneDTO;
	}
}
