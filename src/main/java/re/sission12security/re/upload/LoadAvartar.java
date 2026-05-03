package re.sission12security.re.upload;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class LoadAvartar {
    public String aupload(MultipartFile file) {
        // 1. Định nghĩa đường dẫn thư mục gốc
        String linkFolder = "D:\\WEBSpring\\uploads";

        // 2. Tạo tên file duy nhất để tránh bị ghi đè (Dùng UUID là rất tốt)
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        try {
            // 3. Tạo file đích dựa trên thư mục và tên file
            File destFile = new File(linkFolder + File.separator + fileName);

            // 4. Lưu file vật lý vào ổ đĩa
            file.transferTo(destFile);

            // 5. Trả về đường dẫn tuyệt đối của file vừa lưu
            return destFile.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace();
            return "Lỗi khi lưu file: " + e.getMessage();
        }
    }
}
