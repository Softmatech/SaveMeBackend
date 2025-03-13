import { DateField, Show, TabbedShowLayout, TextField } from "react-admin";

const PersonShow = () => (
  <Show>
    <TabbedShowLayout>
      <TabbedShowLayout.Tab label="Info">
        <TextField source="firstName" label="Prenom" />
        <TextField source="lastName" label="Nom" />
        <TextField source="sexe" />
        <TextField source="email" label="Courrier" />
        <DateField source="birthDate" label="Date de Naissance" />
      </TabbedShowLayout.Tab>

      <TabbedShowLayout.Tab label="Meta">
        <TextField source="birthPlace" label="Lieu de Naissance" />
        <TextField source="adress" label="Addresse" />
        <TextField source="livingCountry" label="Lieu de residence" />
        <TextField source="nationalite" label="Nationalité" />
        <TextField source="documentId" label="Document" />
      </TabbedShowLayout.Tab>

      <TabbedShowLayout.Tab label="Doc">
        <TextField source="documentType" label="Type de Document" />
        <TextField source="motherName" label="Nom de la mère" />
        <TextField source="livingCountry" label="Lieu de residence" />
        <TextField source="contactName" label="Contact" />
        <TextField source="matrimonialStatus" label="Statut Matrimoniale" />
      </TabbedShowLayout.Tab>
    </TabbedShowLayout>
  </Show>
);

export default PersonShow;
