package poly.edu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="nguoiDung")
@Service
public class NguoiDung implements Serializable {
@Id
@Column(columnDefinition = "NVARCHAR(255)")
String Id;
@Column(columnDefinition = "NVARCHAR(255)")
String hoTen;
@Column(columnDefinition = "VARCHAR(13)")
String soDienThoai;
@Column(columnDefinition = "NVARCHAR(255)")
String email;
@Column(columnDefinition = "NVARCHAR(255)")
String matKhau;
boolean isAdmin  = false;



@OneToMany(mappedBy = "nguoiDung")
 List<KetQua> KetQua;
}
