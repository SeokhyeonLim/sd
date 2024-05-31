package Stream;

import java.util.List;

public class Test {
    static class MemberEntity {
        private Long id;
        private String email;
        private String password;

        MemberEntity(Long id, String email, String password) {
            this.id = id;
            this.email = email;
            this.password = password;
        }

        public Long getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {
        List<MemberEntity> memberEntities = List.of(
                new MemberEntity(1L, "user1@aaa.com", "1234"),
                new MemberEntity(2L, "user2@aaa.com", "1234"),
                new MemberEntity(3L, "user3@aaa.com", "1234"),
                new MemberEntity(4L, "user4@aaa.com", "1234"),
                new MemberEntity(5L, "user5@aaa.com", "1234")
        );

        memberEntities.stream()
                .map(entity -> String.format("[%d, %s]", entity.getId(), entity.getEmail()))
                .forEach(System.out::println);
    }
}
