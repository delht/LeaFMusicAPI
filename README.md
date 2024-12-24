1. Giới thiệu
  - Spring boot
  - Database (mysql): https://github.com/delht/LeaFMusicAPI/tree/master/src/main/java/online/delht/leafmusicapi/database
  - Cung cấp dữ liệu cho:
    - Ứng dụng android: https://github.com/delht/LeafMusic
    - Giao diện admin: https://github.com/delht/AdminLeafMusic

2.  Chức năng nổi bật
  - Upload file hình ảnh, mp3 lên Cloudinary + lưu link vào csdl
  - Xóa từ csdl đồng thời xóa file tương ứng theo link được lưu trên Cloudinary
  - Gửi email

3. Hướng dẫn cấu hình kết nối
  - Kết nối csdl:
      -  application.properties
      -      spring.datasource.url=jdbc:mysql://<địa chỉ host>/<tên csdl>?useSSL=false&serverTimezone=UTC
             pring.datasource.username=
             pring.datasource.password=
 -  Kết nối Cloudinary:
      -  ConfigCloudinary
      -     config.put("cloud_name", "<cloud_name>");
            config.put("api_key", "<api_key>");
            config.put("api_secret", "<api_secret>");
  -  Kết nối để gửi email:
      -  application.properties
      -      spring.mail.username=<email tài khoản google>
             pring.mail.password=<mật khẩu ứng dụng google>
