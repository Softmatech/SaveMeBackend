import {
  fetchUtils,
  DataProvider,
  GetListParams,
  GetListResult,
} from "react-admin";

const apiUrl = "http://localhost:4000/api"; // Replace with your API base URL
const httpClient = fetchUtils.fetchJson;

const dataProvider: DataProvider = {
  // Fetch a list of resources with pagination
  getList: (resource: string, params: GetListParams) => {
    const { page, perPage } = params;

    // Construct the API URL with pagination params
    const url = `${apiUrl}/${resource}?page=${0}&size=${10}`;

    return httpClient(url)
      .then(({ json, headers }) => {
        // Parse the total count from the 'Content-Range' header
        const contentRange = headers.get("Content-Range");
        let total = 0;

        if (contentRange) {
          const match = contentRange.match(/persons (\d+)-(\d+)\/(\d+)/);
          if (match) {
            total = parseInt(match[3], 10);
          }
        }

        // Return the data and total count for pagination
        return {
          data: json,
          total,
        };
      })
      .catch((error) => {
        console.error("Error fetching list", error);
        throw new Error("Failed to fetch data");
      });
  },

  // Get a single resource by id
  getOne: (resource: string, params: { id: any }) => {
    const url = `${apiUrl}/${resource}/${params.id}`;
    return httpClient(url)
      .then(({ json }) => ({
        data: json,
      }))
      .catch((error) => {
        console.error("Error fetching resource", error);
        throw new Error("Failed to fetch resource");
      });
  },

  //   // Create a new resource
  create: (resource: string, params: { data: any }) => {
    const url = `${apiUrl}/${resource}`;
    return httpClient(url, {
      method: "POST",
      body: JSON.stringify(params.data),
    })
      .then(({ json }) => ({
        data: { ...params.data, id: json.id },
      }))
      .catch((error) => {
        console.error("Error creating resource", error);
        throw new Error("Failed to create resource");
      });
  },

  // Update an existing resource
  update: (resource: string, params: { id: any; data: any }) => {
    const url = `${apiUrl}/${resource}/${params.id}`;
    return httpClient(url, {
      method: "PUT",
      body: JSON.stringify(params.data),
    })
      .then(({ json }) => ({
        data: json,
      }))
      .catch((error) => {
        console.error("Error updating resource", error);
        throw new Error("Failed to update resource");
      });
  },

  //   // Delete a resource
  //   delete: (resource: string, params: { id: any }) => {
  //     const url = `${apiUrl}/${resource}/${params.id}`;
  //     return httpClient(url, {
  //       method: "DELETE",
  //     })
  //       .then(() => ({
  //         data: { id: params.id },
  //       }))
  //       .catch((error) => {
  //         console.error("Error deleting resource", error);
  //         throw new Error("Failed to delete resource");
  //       });
  //   },
};

export default dataProvider;
