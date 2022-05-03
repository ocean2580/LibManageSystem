package book.manage.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    Integer bid;
    String title;
    String desc;
    Double price;
}
