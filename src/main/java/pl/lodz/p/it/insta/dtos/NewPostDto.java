package pl.lodz.p.it.insta.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class NewPostDto {
   String description;
   byte[] lob;
}
