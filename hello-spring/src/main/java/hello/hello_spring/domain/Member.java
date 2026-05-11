package hello.hello_spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity//JPA가 관리하는 엔티티
public class Member {

    @Id//pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//db가 id를 자동으로 생성
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
