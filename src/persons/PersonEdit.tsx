import {
  DateField,
  DateInput,
  Edit,
  SelectField,
  TabbedForm,
  TextInput,
} from "react-admin";

const PersonEdit = () => (
  <Edit>
    <TabbedForm>
      <TabbedForm.Tab label="Info">
        <TextInput source="firstName" label="Prenom" />
        <TextInput source="lastName" label="Nom" />
        <TextInput source="sexe" />
        <TextInput source="email" label="Courrier" />
        <DateInput source="birthDate" label="Date de Naissance" />
      </TabbedForm.Tab>

      <TabbedForm.Tab label="Meta">
        <TextInput source="birthPlace" label="Lieu de Naissance" />
        <TextInput source="adress" label="Addresse" />
        <TextInput source="livingCountry" label="Lieu de residence" />
        <TextInput source="nationalite" label="Nationalité" />
        <TextInput source="documentId" label="Document" />
      </TabbedForm.Tab>

      <TabbedForm.Tab label="Doc">
        <TextInput source="documentType" label="Type de Document" />
        <TextInput source="motherName" label="Nom de la mère" />
        <TextInput source="livingCountry" label="Lieu de residence" />
        <TextInput source="contactName" label="Contact" />
        <TextInput source="matrimonialStatus" label="Statut Matrimoniale" />
      </TabbedForm.Tab>
    </TabbedForm>
  </Edit>
);
export default PersonEdit;
