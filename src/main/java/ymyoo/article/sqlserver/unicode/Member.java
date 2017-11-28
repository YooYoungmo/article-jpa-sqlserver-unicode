package ymyoo.article.sqlserver.unicode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name="MEMBER_ID", columnDefinition = "NVARCHAR(20)")
    private String memberId;

    @Column(name="MEMBER_NAME", columnDefinition = "NVARCHAR(20)")
    private String memberName;

    @Column(name="AGE")
    private Integer age;

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public Integer getAge() {
        return age;
    }
}
