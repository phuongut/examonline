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
@Table(name="binhLuan")
@Service
public class BinhLuan implements Serializable{
	@Id
String idBinhLuan;
	@Column(columnDefinition = "NVARCHAR(255)")
String noiDung;
	@Column(columnDefinition = "NVARCHAR(255)")
	String anh;
	@Column(columnDefinition = "NVARCHAR(255)")
	String tieude;


@ManyToOne
@JoinColumn(name="idNguoiDung")
 NguoiDung nguoiDung;

}
