import { Admin, Resource } from "react-admin";
import { Layout } from "./Layout";
import PersonList from "./persons/PersonList";
import dataProvider from "./dataProvider";
import { fetchUtils } from "react-admin";
import PersonShow from "./persons/PersonShow";
import PersonEdit from "./persons/PersonEdit";
import { create } from "domain";
import PersonCreate from "./persons/PersonCreate";

const fetchJson = (url: string, options: fetchUtils.Options = {}) => {
  const customHeaders = (options.headers ||
    new Headers({
      Accept: "application/json",
    })) as Headers;
  // add your own headers here
  customHeaders.set("X-Custom-Header", "foobar");
  options.headers = customHeaders;
  return fetchUtils.fetchJson(url, options);
};

export const App = () => (
  <Admin layout={Layout} dataProvider={dataProvider}>
    <Resource
      name="persons"
      list={PersonList}
      show={PersonShow}
      edit={PersonEdit}
      create={PersonCreate}
    />
  </Admin>
);
