package poly.edu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ketQua")
@Service
public class KetQua implements Serializable {
	@Id
	
String idKetQua;
double diem;
@ManyToOne
@JoinColumn(name="idMon")
 MonHoc monHoc;

@ManyToOne
@JoinColumn(name="idNguoiDung")
 NguoiDung nguoiDung;

@ManyToOne
@JoinColumn(name="idBaiThi")
 BaiThi BaiThi;

}
