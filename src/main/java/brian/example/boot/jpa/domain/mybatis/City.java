package brian.example.boot.jpa.domain.mybatis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {

    @Id
    @Column(name = "city_id")
    private int cityId;
    
    @Column(name = "provice_id")
    private int provinceId;

    @Column(name = "name")
    private String name;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
