package book.manage.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    Integer sid;
    String name;
    String sex;
    Integer grade;
}
