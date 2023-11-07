package poly.edu.model;

import java.io.Serializable;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="baiThi")
@Service
public class BaiThi implements Serializable {
	
	@Id
	@Column(columnDefinition = "NVARCHAR(255)")
	String idBaiThi;
	@Column(columnDefinition = "NVARCHAR(255)")
	String tieuDe;
	@Column(columnDefinition = "NVARCHAR(255)")
	String cauHoi;
	@Column(columnDefinition = "NVARCHAR(255)")
	String loiGiai;
	
	
	@ManyToOne
	@JoinColumn(name="idMon")
	 MonHoc monHoc;

	
	@ManyToOne
	@JoinColumn(name="idNguoiDung")
	 NguoiDung nguoiDung;
	
	@OneToMany(mappedBy = "BaiThi")
	List<BaiThi> BaiThi;


}
