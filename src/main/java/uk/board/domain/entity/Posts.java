package uk.board.domain.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uk.board.domain.entity.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity// 1 JPA Annotation. 테이블과 링크될 클래스임을 나타냄. 클래스의 카멜케이스 이름 -> 언더스코어 네이밍으로 테이블 이름 매칭하게 됨.
@Table(name = "board")
public class Posts extends TimeEntity { //실제 Database와 매칭될 클래스. 주로 Entity 클래스라고 부름. JPA를 이용해서 DB 데이터에 작업할 경우, 실제 쿼리를 날리기보다는, Entity 클래스의 수정을 통해 작업하게 될 것.
    @Id     //2 해당 테이블의 PK 필드를 말함.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //3. PK의 생성 규칙을 말함. GenerationType.IDENTITY : auto_increment
    private Long id;

    @Column(length=500, nullable = false)     //4 추가로 변경이 필요한 옵션이 있을 경우 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String writer;

    @Builder
    public Posts(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void update(String title, String content){
        this.title=title;
        this.content = content;
    }
}