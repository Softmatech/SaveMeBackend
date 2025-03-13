import {
  Create,
  DateInput,
  SelectInput,
  SimpleForm,
  required,
  TextInput,
} from "react-admin";

const sexes = [
  { id: 0, name: "Masculin" },
  { id: 1, name: "Feminin" },
];

const documentTypes = [
  { id: 0, name: "PASSPORT" },
  { id: 1, name: "CARTE_ELECTORAL" },
  { id: 2, name: "CARTE_IDENTITICATION" },
  { id: 3, name: "AUTRES" },
];

const PersonCreate = () => (
  <Create>
    <SimpleForm>
      {/* <TabbedForm> */}
      {/* <TabbedForm.Tab label="Info"> */}
      <TextInput source="firstName" label="Prenom" />
      <TextInput source="lastName" label="Nom" />
      <SelectInput source="sexe" choices={sexes} validate={required()} />
      <TextInput source="email" label="Courrier" />
      <DateInput source="birthDate" label="Date de Naissance" />
      {/* </TabbedForm.Tab> */}

      {/* <TabbedForm.Tab label="Meta"> */}
      <TextInput source="birthPlace" label="Lieu de Naissance" />
      <TextInput source="adress" label="Addresse" />
      <TextInput source="livingCountry" label="Lieu de residence" />
      <TextInput source="nationalite" label="Nationalité" />
      <TextInput source="documentId" label="Document" />
      {/* </TabbedForm.Tab> */}

      {/* <TabbedForm.Tab label="Doc"> */}
      <SelectInput
        source="documentType"
        label="Type de Document"
        choices={documentTypes}
        validate={required()}
      />
      <TextInput source="motherName" label="Nom de la mère" />
      <TextInput source="livingCountry" label="Lieu de residence" />
      <TextInput source="contactName" label="Contact" />
      <TextInput source="matrimonialStatus" label="Statut Matrimoniale" />
      {/* </TabbedForm.Tab>
      </TabbedForm> */}
    </SimpleForm>
  </Create>
);
export default PersonCreate;
