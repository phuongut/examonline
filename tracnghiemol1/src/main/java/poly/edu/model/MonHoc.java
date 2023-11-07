package poly.edu.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="monHoc")
@Service
public class MonHoc implements Serializable {
@Id
String Id;
@Column(columnDefinition = "NVARCHAR(255)")
String tenMonHoc;
@Column(columnDefinition = "VARCHAR(100)")
String hinhAnh;
Time thoigian;
@Column(columnDefinition = "NVARCHAR(255)")
String filemon;

@ManyToOne
@JoinColumn(name="idBan")
 Ban Ban;


@OneToMany(mappedBy = "monHoc")
List<KetQua> KetQua;

@OneToMany(mappedBy = "monHoc")
List<BaiThi> baiThi;


}
