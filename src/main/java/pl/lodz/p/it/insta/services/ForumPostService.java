package pl.lodz.p.it.insta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.it.insta.entities.ForumPost;
import pl.lodz.p.it.insta.repositories.ForumPostRepository;

import java.util.List;

@Service
public class ForumPostService {

        private final ForumPostRepository forumPostRepository;

        @Autowired
        public ForumPostService(ForumPostRepository forumPostRepository) {
            this.forumPostRepository = forumPostRepository;
        }

        public List<ForumPost> getAll() {
            return forumPostRepository.findAll();
        }

}
