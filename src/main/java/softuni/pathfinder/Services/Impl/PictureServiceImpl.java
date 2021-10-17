package softuni.pathfinder.Services.Impl;

import org.springframework.stereotype.Service;
import softuni.pathfinder.Repositories.PictureRepository;
import softuni.pathfinder.Services.PictureService;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllPictures() {
        return this.pictureRepository.findAllUrls();
    }
}
