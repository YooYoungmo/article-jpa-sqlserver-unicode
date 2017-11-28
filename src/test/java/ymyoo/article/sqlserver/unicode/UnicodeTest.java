package ymyoo.article.sqlserver.unicode;


import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class UnicodeTest {
    final String PERSISTENCE_UNIT_NAME = "article";
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    @Test
    public void test() {
        // given
        final String memberId = "slackbeck";

        // when
        EntityManager em = this.emf.createEntityManager();
        Member actual = em.find(Member.class, memberId);

        // then
        Assert.assertEquals("유영모", actual.getMemberName());
        Assert.assertEquals(10, actual.getAge().intValue());
    }

    @Test
    public void test_JPQL() {
        // given
        final int age = 30;

        // when
        EntityManager em = this.emf.createEntityManager();
        TypedQuery<Member> query  = em.createQuery("select m from Member m WHERE m.age=:age", Member.class);
        query.setParameter("age", age);

        List<Member> members = query.getResultList();

        // then
        Assert.assertEquals(2, members.size());
    }

    @Test
    public void test_native_sql() {
        // given
        final int age = 30;

        // when
        EntityManager em = this.emf.createEntityManager();
        Query nativeQuery =
                em.createNativeQuery("select member_id, member_name, age " +
                        "from member " +
                        "where age=:age")
                .setParameter("age", age);

        List<Member> members = nativeQuery.getResultList();

        // then
        Assert.assertEquals(2, members.size());
    }
}