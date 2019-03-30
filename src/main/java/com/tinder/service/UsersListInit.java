package com.tinder.service;

import com.tinder.dao.DAO;
import com.tinder.dto.User;

public class UsersListInit {
    public void generate(DAO<User> userDao) {
        User user1 = new User(
                "diego@gmail.com",
                "Diego",
                "Maradona",
                "1",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Diego_Maradona_2012_2.jpg/800px-Diego_Maradona_2012_2.jpg"
        );
        User user2 = new User(
                "marco@gmail.com",
                "Marco",
                "van Basten",
                "1",
                "https://m.media-amazon.com/images/M/MV5BZjAxYTI3OGMtODM5Ni00M2MxLWFlNmMtYmI4NjIxYTVlODc2XkEyXkFqcGdeQXVyMjUyNDk2ODc@._V1_SY1000_CR0,0,797,1000_AL_.jpg"
        );

        User user3 = new User(
                "gabriel",
                "Gabriel",
                "Batistuta",
                "1",
                "https://abudhabiblog.com/wp-content/uploads/2015/05/batistuta-argentina-football.jpg"
        );

        User user4 = new User(
                "eric",
                "Eric",
                "Cantona",
                "1",
                "https://news.images.itv.com/image/file/991160/stream_img.jpg"
        );

        User user5 = new User(
                "oleg",
                "Oleg",
                "Blokhin",
                "1",
                "https://lvironpigs.files.wordpress.com/2011/12/1a1a1a1a1a1a1a283.jpg"
        );

        userDao.update(user1);
        userDao.update(user2);
        userDao.update(user3);
        userDao.update(user4);
        userDao.update(user5);
    }
}
