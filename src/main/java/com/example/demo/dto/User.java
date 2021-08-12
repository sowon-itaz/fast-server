package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* ==============================================================================================================
 * @Data: @ToString, @EqualsAndHashCode, @Getter: 모든 필드, @Setter: 정적 필드가 아닌 모든 필드, @RequiredArgsConstructor
 * @NoArgsConstructor: 파라미터가 없는 기본 생성자 생성
 * @AllArgsConstructor: 모든 필드 값을 파라미터로 받는 생성자 생성
 * ============================================================================================================== 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private int age;
}
