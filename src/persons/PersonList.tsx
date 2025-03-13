import { Datagrid, DateField, List, TextField } from "react-admin";

const PersonList = () => (
  <List>
    <Datagrid>
      <TextField source="firstName" label="Prenom" />
      <TextField source="lastName" label="Nom" />
      <TextField source="sexe" />
      <TextField source="email" label="Courrier" />
      <DateField source="birthDate" label="Date de Naissance" />
    </Datagrid>
  </List>
);

export default PersonList;
