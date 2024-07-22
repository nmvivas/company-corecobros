package com.banquito.corecobros.companydoc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "companies")
@CompoundIndexes({
        @CompoundIndex(name = "comidx_company", def = "{'uniqueID': 1, 'commissionId': 1}", unique = true)
})
public class Company {

    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueID;
    @Indexed
    private String commissionId;
    @Indexed(unique = true)
    private String ruc;
    @Indexed
    private String companyName;
    private String status;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
